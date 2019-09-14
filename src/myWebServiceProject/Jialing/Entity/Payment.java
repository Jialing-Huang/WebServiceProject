package myWebServiceProject.Jialing.Entity;

public class Payment{
	private TypeOfCard typeofcard;
	public enum TypeOfCard
	{
		VISA,MASTER,GIFTCARD	
	}
	
	private int card_number;
	
	public Payment() {}
	
	public Payment(TypeOfCard Typeofcard, int Card_number) {
		this.typeofcard = Typeofcard;
		this.card_number = Card_number;
	}

	public TypeOfCard getTypeofcard() {
		return typeofcard;
	}

	public void setTypeofcard(TypeOfCard typeofcard) {
		this.typeofcard = typeofcard;
	}

	public int getCard_number() {
		return card_number;
	}

	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}
	
}
