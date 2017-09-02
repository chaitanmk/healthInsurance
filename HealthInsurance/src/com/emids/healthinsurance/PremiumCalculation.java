package com.emids.healthinsurance;

import com.emids.pojo.Person;

public class PremiumCalculation {

	public static double getPremium(Person person) {
		 String name = person.getName();
		 String gender = person.getGender();
		 int age = person.getAge();
		 Boolean hypertension = person.getHypertension();
		 Boolean bloodPressure= person.getBloodPressure();
		 Boolean bloodSugar = person.getBloodSugar();
		 Boolean overWeight = person.getOverWeight();
		 Boolean smoking = person.getSmoking();
		 Boolean alcohol = person.getAlcohol();
		 Boolean dailyExcercise = person.getDailyExcercise();
		 Boolean drugs= person.getDrugs();
		double basePrem = 5000;
		double premium = 0;
		
		//18-25 -> + 10% | 25-30 -> +10% | 30-35 -> +10% | 35-40 -> +10% | 40+ -> 20% 
		//increase every 5 years
		if(age < 18) {
			premium = basePrem;
		} else if(age >= 18 && age <= 25) {
			premium =basePrem + (basePrem *10)/100;
		} else if(age > 25 && age <= 30) {
			premium =basePrem + (basePrem *10)/100;
		} else if(age >30 && age <= 35) {
			premium =basePrem + (basePrem *10)/100;
		} else if(age >35 && age <= 40) {
			premium =basePrem + (basePrem *10)/100;
		} else {
			int excessAge = age-40;
			premium = basePrem + ((basePrem *20)/100)*(excessAge/5);
		}
		
		//Increase 2% over standard slab for Males
		if(gender.equalsIgnoreCase("male"))
		{
			premium+= (basePrem *2)/100;
		}
		
		if(hypertension) {
			premium = premium + (basePrem * 0.01);
		}
		if(bloodPressure) {
			premium = premium + (basePrem * 0.01);
		}
		if(bloodSugar) {
			premium = premium + (basePrem * 0.01);
		}
		if(overWeight) {
			premium = premium + (basePrem * 0.01);
		}
		if(dailyExcercise) {
			premium = premium - (basePrem * 0.03);
		}
		if(smoking) {
			premium = premium + (basePrem * 0.03);
		}
		if(alcohol) {
			premium = premium + (basePrem * 0.03);
		}
		if(drugs) {
			premium = premium + (basePrem * 0.03);
		}
		
		return premium;
	}
	public static void main(String args[]) {
		Person person = new Person();
		person.setAlcohol(true);
		
		person.setName("Norman Gomes");
		person.setGender("Male");
		person.setAge(34);
		person.setHypertension(false);
		person.setBloodPressure(false);
		person.setBloodSugar(false);
		person.setOverWeight(true);
		person.setSmoking(false);
		person.setAlcohol(true);
		person.setDailyExcercise(true);
		person.setDrugs(false);

		double premium = getPremium(person);
		System.out.println("Premium for "+person.getName()+" is "+premium);
		
		
	}
	
}
