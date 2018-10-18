public class RationalNumber extends RealNumber{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0);//this value is ignored!
    if (deno == 0){
    numerator = 0;
    denominator = 1;
  }
  numerator = nume;
  denominator = deno;
  reduce();

}
  public double getValue(){
    if (numerator == 0){
	return 0.0;}
    if (denominator == 1){
	return (double)numerator;
  }
  return (double)numerator / denominator;
}
  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(this.getDenominator(),this.getNumerator());
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (this.getNumerator() == 0 && other.getNumerator() == 0){
      return true;
    }
    if (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator()){
      return true;
    }
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (this.getNumerator() == 0){
      return "0";
    }
    if (this.getDenominator() == 1){
      return this.getNumerator() + "";
    }
    if (this.getDenominator() < 0){
      return (this.getNumerator() * -1) + " / " + (this.getDenominator() * -1);
    }
    // if (this.getNumerator() == this.getDenominator()){
    //   return 1 + "" ;
    // }
    return this.getNumerator() + " / " + this.getDenominator();
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */

  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    int R = 1;
    if (a == 0 ){
      return R;
    }
    int Big;
    int Small;
    if (b > a){
    Big = b;
    Small = a;
  }
  else {
    Big = a;
    Small = b;
  }

    while (R != 0){
  		R = Big % Small;
  		Big = Small;
  		Small = R;
    }
  	return Big;
    }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int N = numerator;
    int D = denominator;
    int gcd = RationalNumber.gcd(getNumerator(),getDenominator());
    N = N / gcd;
    D = D / gcd;
    numerator = N;
    denominator = D;
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber(this.getNumerator() * other.getDenominator(), this.getDenominator() * other.getNumerator());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber((this.getNumerator() * other.getDenominator ()) + (other.getNumerator() * this.getDenominator ()),this.getDenominator() * other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber((this.getNumerator() * other.getDenominator ()) - (other.getNumerator() * this.getDenominator ()),this.getDenominator() * other.getDenominator());
  }

}
