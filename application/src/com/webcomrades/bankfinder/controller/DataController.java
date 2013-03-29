package com.webcomrades.bankfinder.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.webcomrades.bankfinder.datafetcher.DataFetcher;
import com.webcomrades.bankfinder.datafetcher.DataFetcher.ResponseHandler;
import com.webcomrades.bankfinder.model.Bank;
import com.webcomrades.bankfinder.model.Brand;

/**
 * @author Jo Somers - sayhello@josomers.be
 * @since 2013
 */

public class DataController {

	private final String mBankPath;
	private final String mBrandPath;
	private final DataFetcher mDataFetcher;
	
	public DataController(String bankPath, String brandPath, DataFetcher dataFetcher) {
		this.mBankPath = bankPath;
		this.mBrandPath = brandPath;
		this.mDataFetcher = dataFetcher;
	}
	
	public List<Bank> getBanks() throws IOException {	
		return DataParser.parseBanks(mDataFetcher.get(new ResponseHandler() {
			@Override
			public String handleResponse(InputStream input) throws IOException {
				return IOUtils.toString(input);
			}
		}, mBankPath));
	}
	
	public List<Brand> getBrands() throws IOException {
		return DataParser.parseBrands(mDataFetcher.get(new ResponseHandler() {
			@Override
			public String handleResponse(InputStream input) throws IOException {
				return IOUtils.toString(input);
			}
		}, mBrandPath));
	}

	public Bank postBank(Bank mNewBank) throws IOException {
		return DataParser.parseBank(mDataFetcher.post(new ResponseHandler() {
			@Override
			public String handleResponse(InputStream input) throws IOException {
				return IOUtils.toString(input);
			}
		}, mBankPath, new Gson().toJson(mNewBank)));
	}
	
}
