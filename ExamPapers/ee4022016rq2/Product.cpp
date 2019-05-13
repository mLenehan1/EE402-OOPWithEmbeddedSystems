/*
 * Product.cpp
 *
 *  Created on: 9 Jan 2019
 *      Author: mlenehan
 */

#include "Product.h"

ostream & operator<<(ostream & os, const Product &p){
	return os << "[Product Type:" << p.getProductType() << "desc:" << p.description
			<< "stock:" << p.stockLevel << p.uniqueStockNumber << "]";
}

Product::Product(string description, float price, int stockLevel) :
		description(description), price(price), stockLevel(stockLevel){
	cout << "A Product was Created" << endl;

}

void Product::display(){
	cout << "Description: " << description << endl;
	cout << "Price: " << price << endl;
	cout << "Stock Level: " << stockLevel << endl;
}

Book::Book(string description, float price, int stockLevel, string genre, int numberOfPages) :
		Product(description, price, stockLevel), genre(genre), numberOfPages(numberOfPages){
	cout << "A Book was Created" << endl;
}

void Book::display(){
	Product::display();
	cout << "Genre: " << genre << endl;
	cout << "Number of Pages: " << numberOfPages << endl;
}

Movie::Movie(string description, float price, int stockLevel, string mediaType, float duration) :
		Product(description, price, stockLevel), mediaType(mediaType), duration(duration){
	cout << "A Movie was Created" << endl;
}

void Movie::display(){
	Product::display();
	cout << "Media Type: " << mediaType << endl;
	cout << "Duration: " << duration << endl;
}

int main(){
	Book *p;
	cout << "Start of Application" << endl;
	{
		p = new Book("How to Program - Book", 25.00f, 5, "Comedy", 250);
		cout << *p;
	}
	cout << "End of Application" << endl;
	delete p;
	return 0;
}
