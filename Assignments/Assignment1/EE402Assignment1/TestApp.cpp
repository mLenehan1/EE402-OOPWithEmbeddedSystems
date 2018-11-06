/*
 * TestApp.cpp
 *
 *  Created on: 27 Oct 2018
 *      Author: mlenehan
 */

#include "Instrument.h"
#include "Guitar.h"
#include "Piano.h"
#include "ElectricGuitar.h"
#include "AcousticGuitar.h"
#include "AcousticPiano.h"
#include "ElectroAcousticGuitar.h"
#include "ObjectStorage.h"
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

template<class T>class dispFunc{
public:
	void operator () (T x){
		x.display();
	}
};

struct InstrumentStruct{
	int serialNumber;
	string manufacturer;
	float price;
	void changeSerialNumber();
	void display();
};

void InstrumentStruct::display(){
	cout << this->serialNumber << endl;
	cout << this->manufacturer << endl;
	cout << this->price << endl;
}

void InstrumentStruct::changeSerialNumber(){
	serialNumber++;
}

//Friend Function
void salePrice(Instrument &saleInstrument, float discount){
	saleInstrument.price = saleInstrument.price-discount;
	cout << "Rounded Guitar Sale Price: " << static_cast<int>(saleInstrument.price) << "." << endl;
}

string changePianoShapePBV(AcousticPiano source, string newShape){
	source.display();
	return source.pianoShape + " Changed to " + newShape;
}

void changePianoShapePBR(AcousticPiano &source, string newShape){
	source.pianoShape = source.pianoShape + " Changed to " + newShape;
	source.display();
}

void showPianoShapeCPBR(const AcousticPiano &source){
	cout << source.pianoShape << endl;
	//source.pianoShape = "Cannot Make Changes Here";
}

//Dynamic Binding
void displayGuitarInfo(Guitar &A){
	A.display();
}

int main(){


	const float discount = 400.55;

	//Constructor Overloading

	/*
	ElectricGuitar testElectric1 = ElectricGuitar("Gibson", 2400, "LP", 6, 2, "Humbucker");
	AcousticGuitar testAcoustic1 = AcousticGuitar("Taylor", 800, "Dreadnought", 12, 1);
	ElectricGuitar testElectric2 = ElectricGuitar(12345, "Gibson", 2400, "LP", 6, 2, "Humbucker");
	AcousticGuitar testAcoustic2 = AcousticGuitar(12611, "Taylor", 800, "Dreadnought", 12, 1);
	*/
	AcousticPiano testAcousticPiano = AcousticPiano("Yamaha", 1200, 88, "Upright");


	//Copy Constructor Pass-By-Value Pass-By-Reference Constant-Pass-By-Reference

	/*
	testAcousticPiano.pianoShape = changePianoShapePBV(testAcousticPiano, "Grand");
	testAcousticPiano.display();
	changePianoShapePBR(testAcousticPiano, "Baby Grand");
	testAcousticPiano.display();
	*/
	showPianoShapeCPBR(testAcousticPiano);
	testAcousticPiano.display();


	/*
	//Pointers to Object Arrays

	Piano *arr = new Piano[2];
	arr[0] = Piano("Yamaha", 1200, 88);
	arr[1] = Piano("Thomann", 600, 88);
	 */

	/*
	//Operator Overloading
	Piano addPiano1 = arr[0]+arr[1];
	Piano addPiano2 = addPiano1;
	if(arr[0]==arr[1]){
		cout << "Matching Pianos." << endl;
	}
	else cout << "Non-matching Pianos" << endl;
	if(addPiano1==addPiano2){
		cout << "Matching Pianos." << endl;
	}
	else cout << "Non-matching Pianos" << endl;
	delete arr;
	*/

	/*
	//Multiple Inheritance
	ElectroAcousticGuitar testElectroAcoustic1 = ElectroAcousticGuitar("Gretsch", 5000, "G2622T", 6, 2, 2, "Humbucker");
	ElectroAcousticGuitar testElectroAcoustic2 = ElectroAcousticGuitar(72247, "Gretsch", 5000, "G2622T", 6, 2, 2, "Humbucker");
	*/

	/*
	//Dynamic Casting & Reinterpret Casting
	Instrument& upCastInstrument = testElectroAcoustic1;
	ElectricGuitar& downCastElectric = dynamic_cast<ElectricGuitar&>(upCastInstrument);
	downCastElectric.display();
	AcousticGuitar *reintAcoustic = new AcousticGuitar("Martin", 900, "Jumbo", 6, 1);
	reintAcoustic->noOfSoundholes = 0;
	long longAcoustic = reinterpret_cast<long>(reintAcoustic);
	cout << longAcoustic << endl;
	AcousticGuitar *reintCastAcoustic = reinterpret_cast<AcousticGuitar*>(longAcoustic);
	delete reintAcoustic;
	cout << reintCastAcoustic->noOfSoundholes << endl;
	testElectric1.display();
	testAcoustic1.display();
	testElectroAcoustic1.display();
	*/

	/*
	// Friend Function & Constant Cast
	salePrice(testElectroAcoustic1, *const_cast<float*>(&discount));
	testElectroAcoustic1.display();
	*/

	/*
	//Dynamic Binding
	displayGuitarInfo(testAcoustic1);
	*/

	/*
	//Structs
	InstrumentStruct testStructObject;
	testStructObject.serialNumber = 12345;
	testStructObject.manufacturer = "TestManufacturer";
	testStructObject.price = 12500.50;
	testStructObject.display();
	//Unspecified Access Specifiers - In Class would be private, in Struct are public
	testStructObject.changeSerialNumber();
	testStructObject.display();
	*/

	/*
	//Vector Container and Sort
	vector<Piano> pianoVector;
	pianoVector.push_back(Piano(12456, "Test", 1200, 88));
	pianoVector.push_back(Piano(87456, "Test", 1200, 88));
	pianoVector.push_back(Piano(12556, "Test", 1200, 88));
	pianoVector.push_back(Piano(99999, "Test", 1200, 88));
	pianoVector.push_back(Piano(50820, "Test", 1200, 88));
	sort(pianoVector.begin(), pianoVector.end());
	for_each(pianoVector.begin(), pianoVector.end(), dispFunc<Piano>());
	*/
}
