package com.example.designpatterns.adapter;

public class NewLineFormatter implements LineFormattable {

	@Override
	public String formatText(String text) {
		String formattedText = text.replace(".", "\n");
		return formattedText;
	}

}
