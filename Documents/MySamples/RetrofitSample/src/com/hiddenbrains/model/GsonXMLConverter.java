package com.hiddenbrains.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

public class GsonXMLConverter implements Converter {
	private final GsonXml gson;
	private String charset;

	/**
	 * Create an instance using the supplied {@link Gson} object for conversion.
	 * Encoding to JSON and decoding from JSON (when no charset is specified by
	 * a header) will use UTF-8.
	 */
	public GsonXMLConverter() {
		this("UTF-8");
	}

	/**
	 * Create an instance using the supplied {@link Gson} object for conversion.
	 * Encoding to JSON and decoding from JSON (when no charset is specified by
	 * a header) will use the specified charset.
	 */
	public GsonXMLConverter(String charset) {
		XmlParserCreator parserCreator = new XmlParserCreator() {
		    @Override
		    public XmlPullParser createParser() {
		      try {
		        return XmlPullParserFactory.newInstance().newPullParser();
		      } catch (Exception e) {
		        throw new RuntimeException(e);
		      }
		    }
		  };

		  this.gson = new GsonXmlBuilder()
		     .setXmlParserCreator(parserCreator)
		     .create();
		this.charset = charset;
	}

	@Override
	public Object fromBody(TypedInput body, Type type)
			throws ConversionException {
		String charset = this.charset;
		if (body.mimeType() != null) {
			charset = MimeUtil.parseCharset(body.mimeType());
		}
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(body.in(), charset);
			
			
			  return gson.fromXml(isr, type);
			
		} catch (IOException e) {
			throw new ConversionException(e);
		} catch (JsonParseException e) {
			throw new ConversionException(e);
		} finally {
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException ignored) {
				}
			}
		}
	}

	@Override
	public TypedOutput toBody(Object object) {
		try {
			
			return new XmlTypedOutput(gson.getGson().toJson(object).getBytes(charset),
					charset);
		} catch (UnsupportedEncodingException e) {
			throw new AssertionError(e);
		}
	}

	private static class XmlTypedOutput implements TypedOutput {
		private final byte[] jsonBytes;
		private final String mimeType;

		XmlTypedOutput(byte[] jsonBytes, String encode) {
			this.jsonBytes = jsonBytes;
			this.mimeType = "application/xml; charset=" + encode;
		}

		@Override
		public String fileName() {
			return null;
		}

		@Override
		public String mimeType() {
			return mimeType;
		}

		@Override
		public long length() {
			return jsonBytes.length;
		}

		@Override
		public void writeTo(OutputStream out) throws IOException {
			out.write(jsonBytes);
		}
	}
}