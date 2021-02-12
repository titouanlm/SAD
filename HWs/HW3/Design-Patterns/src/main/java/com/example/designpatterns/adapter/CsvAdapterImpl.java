package com.example.designpatterns.adapter;

public class CsvAdapterImpl implements LineFormattable{

	private CsvFormattable csvFormatter;
	
	public CsvAdapterImpl(CsvFormattable csvFormatter) {
		super();
		this.csvFormatter = csvFormatter;
	}

	@Override
	public String formatText(String text) {
		String formattedText = this.csvFormatter.formatCsvText(text);
		return formattedText;
	}

}
