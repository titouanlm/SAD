package com.example.transactionscript.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transactionscript.gateway.RevenueRecognitionTableDataGateway;

@Service
public class RevenueRecognitionFactory {

	@Autowired
	RevenueRecognitionTableDataGateway recognitionGateway;
	
	public static final CurrencyUnit CURRENCY = Monetary.getCurrency("USD");
	
	public void calculateRevenueRecognitions(String type, int contractId, BigDecimal totalRevenue, LocalDate dateSigned) {
		if ("WORDPROCESSOR".equals(type)) {
			recognitionGateway.insert(contractId, totalRevenue, dateSigned);
		} else if ("SPREADSHEET".equals(type)) {
			BigDecimal allocations[] = allocate(totalRevenue, 3);
			recognitionGateway.insert(contractId, allocations[0], dateSigned);
			recognitionGateway.insert(contractId, allocations[1], dateSigned.plusDays(60));
			recognitionGateway.insert(contractId, allocations[2], dateSigned.plusDays(90));
		} else if ("DATABASE".equals(type)) {
			BigDecimal allocations[] = allocate(totalRevenue, 3);
			recognitionGateway.insert(contractId, allocations[0], dateSigned);
			recognitionGateway.insert(contractId, allocations[1], dateSigned.plusDays(30));
			recognitionGateway.insert(contractId, allocations[2], dateSigned.plusDays(60));
		} else {
			throw new RuntimeException(String.format("Unknown product type [%s]", type));
		}
	}
	
	private BigDecimal[] allocate(BigDecimal totalRevenue, int count) {
		int defaultFractionDigits = CURRENCY.getDefaultFractionDigits();
		
		BigDecimal onePart = totalRevenue.divide(new BigDecimal(count), RoundingMode.HALF_EVEN)
				.setScale(defaultFractionDigits, RoundingMode.HALF_EVEN);
		BigDecimal allocations[] = new BigDecimal[count];
		BigDecimal newTotal = BigDecimal.ZERO.setScale(defaultFractionDigits, RoundingMode.HALF_EVEN);
		for (int i = 0; i < count; i++) {
			allocations[i] = onePart;
			newTotal = newTotal.add(onePart);
		}
		
		if (!newTotal.equals(totalRevenue)) {
			BigDecimal lastAllocation = allocations[count - 1];
			lastAllocation = lastAllocation.add(totalRevenue.subtract(newTotal));
			allocations[count - 1] = lastAllocation;
		}
		return allocations;
	}
}