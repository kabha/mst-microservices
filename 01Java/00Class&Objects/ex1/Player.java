class Player{ 
	private String name;
	private int luckNum;

	public Player(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

	public int getLuckNum(){
		return this.luckNum;
	}

	private int getNum(){
		return (int)(Math.random()*100+1);
	}

	public void setLuckNum(){
		luckNum=getNum();
	}
}
