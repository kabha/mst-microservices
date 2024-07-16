class Game{
	public static void main(String[] args){
		int count1=0,count2=0;
		if(Integer.parseInt(args[0])>0&&Integer.parseInt(args[0])<=10){

			Player p1=new Player("AMI");
			Player p2=new Player("TAMI");

			for(int i=0;i<Integer.parseInt(args[0]);i++){
				p1.setLuckNum();
				p2.setLuckNum();

				if(p1.getLuckNum()>p2.getLuckNum()){
					count1++;
					System.out.println("Round "+(i+1)+"   winner : "+p1.getName());
				}else if(p1.getLuckNum()<p2.getLuckNum()){
					count2++;
					System.out.println("Round "+(i+1)+"   winner : "+p2.getName());
				}else
					i--;					
			}

			if(count1>count2)
				System.out.println("TOTAL WINNER:  "+p1.getName()+"  SCORED: "+count1);
			else if (count1>count2)
				System.out.println("TOTAL WINNER:  "+p2.getName()+"  SCORED: "+count2);
			else
				System.out.println("EVEN - BOTH SCORED: "+count1);
		}
	}
}
			
				
				
