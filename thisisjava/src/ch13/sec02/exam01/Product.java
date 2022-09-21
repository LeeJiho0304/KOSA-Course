package ch13.sec02.exam01;

import lombok.Data;

@Data
public class Product <K, M> {
	public K kind;
	public M model;
	
}
