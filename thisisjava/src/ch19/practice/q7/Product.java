package ch19.practice.q7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int no;
	private String name;
	private int price;
	private int stock;
}
