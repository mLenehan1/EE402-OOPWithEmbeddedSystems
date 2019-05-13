/*
 * Product.h
 *
 *  Created on: 9 Jan 2019
 *      Author: mlenehan
 */

#ifndef PRODUCT_H_
#define PRODUCT_H_

#include <iostream>
#include <string>
using namespace std;

class Product {
protected:
	string description;
	float price;
	int stockLevel;
	int uniqueStockNumber;
	static int nextUniqueStockNumber;
	friend ostream & operator << (ostream & os, const Product &p);
public:
	Product(string, float, int);
	virtual string getProductType()=0;
	virtual void display();
	virtual ~Product() {cout << "Product Object Destoyed" << endl;}
};

class Book: public Product{
private:
	string genre;
	int numberOfPages;
public:
	Book(string, float, int, string, int);
	virtual string getProductType() {return description + " " + genre;}
	virtual void display();
	virtual ~Book() {cout << "Book Object Destroyed" << endl;}
};

class Movie: public Product{
private:
	string mediaType;
	float duration;
public:
	Movie(string, float, int, string, float);
	virtual string getProductType() {return description + " " + mediaType;}
	virtual void display();
	virtual ~Movie() {cout << "Movie Object Destroyed" << endl;}
};

#endif /* PRODUCT_H_ */
