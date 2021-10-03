import java .util.*;

public class Student{
	
			public static Student data [] = new Student[2];
			
			String name;
			String ID;
			int years;
			
			Student(String name,String ID,int years){//constructor
			this.name = name;
			this.ID = ID;
			this.years = years;
			}
					 
		public static void Populate(){
			
			Scanner input = new Scanner(System.in);
			
			String name,id;
			int yrs,i;
				
			for(i=0;i<2;i++){
				
				System.out.print("Enter name:");
				name = input.next();
				System.out.print("Enter ID:");
				id = input.next();
				System.out.print("Enter years of study:");
				yrs = input.nextInt();
				
				 data[i] = new Student(name,id,yrs);
			}			
		}
		
		public static void View(){

			int i;
		
			for(i=0;i<2;i++){
				
				System.out.print("Name:"+data[i].name);
				System.out.print(" ID no:"+data[i].ID);
				System.out.println(" Year of study:"+data[i].years);
				System.out.println(""); 
			}
		}
		
		public static void SelectionSorting(){
			
			int i,j;
			Student temp;
			
			for(i=0;i<2;i++){
			
				for(j=i+1;j<2;j++){
			
					if(data[i].name.compareTo(data[j].name) >0){
						
						temp = data[i];
						data[i]=data[j];
						data[j]=temp;
					
					}	
				}
			}
		}
		
		public static void SelectionSort(){
		
			int i,j;
			Student temp;
			
			for(i=0;i<2;i++){
			
				for(j=i+1;j<2;j++){
			
					if(data[i].ID.compareTo(data[j].ID) >0){
					
						temp = data[i];
						data[i]=data[j];
						data[j]=temp;
					}	
				}
			}
		}
		
		public static void BubbleSort(){
			
			int i,j;
			Student temp;
			
			for(i=0;i<2;i++){
				
				for(j=1;j>i;j--){
		
					if(data[j].name.compareTo(data[j-1].name)<0){
					
						temp = data[j];
						data[j] =data[j-1];
						data[j-1] = temp;
					}
				}
			}
		}	
			
		public static void shellSort(){

			int gap,i;
			Student temp;
			boolean flag = true;
			
			gap =(int)( data.length+1/2);
			
			while(gap > 1 || flag == true){
				
				flag = false;
				
				gap = (int)(gap+1)/2;
				
				for(i=0;i<gap;i++){
					
					if(data[i].years>data[i+gap].years){
						
						temp = data[i];
						data[i] = data[i+gap];
						data[i+gap] = temp;
						flag = true;
					}
				}
			}
		}
		
		/*public static void exchangeSort(){
			int i,j;
			Student temp;
			
			for(i=0;i<1;i++){
				
				for(j=(i+1);j<2;j++){
				
					if(data[i].name.compareTo(data[j].name)<0)
						temp = data[i];
						data[i] = data[j];
						data[j] = temp;
				}
			}
		}*/
		
		public static void SequentialSearch(){
			
			Scanner input = new Scanner(System.in);
			
			int i,position=-1;
			String Temp;//primary key
			
			System.out.print("Enter Id to search:");
			Temp =input.next();
			
			for(i=0;i<data.length;i++){
				
				if(Temp.compareTo(data[i].ID)==0){
					
					position = i;
				}
			}
			if (position >= 0){
					
					System.out.print("name:"+data[position].name);
					System.out.print(" Year of study:"+data[position].years);
				
				}else{
					
					System.out.print("item not found!");
				}
		}
		
		public static void BinarySearch(){
			
			Scanner input = new Scanner(System.in);
			
			int position =-1,LowerB,UpperB,MidP;
			String Temp;//primary key
			
			SelectionSort();
			
			LowerB = 0;
			UpperB =data.length-1;
			
			System.out.print("Enter Id to Search:");
			Temp =input.next();
			
							
			do{
				MidP =(int)(LowerB + UpperB)/2;
				
				if(Temp.compareTo(data[MidP].ID)< 0){
					UpperB = MidP-1;
				}else if(Temp.compareTo(data[MidP].ID) > 0){
					LowerB = MidP+1;
				}else{
						position = MidP;
					}
				
			}while(LowerB <= UpperB && position>-1);
			
				if(position == MidP){
					System.out.print("name:"+data[position].name);
					System.out.print(" Year of study:"+data[position].years);
				}else{
					System.out.print("item not found!");
				}
		} 
		
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		Populate();
		View();
		
		while(true){
			
			int Option;
		
			System.out.print("Enter: \n 1.for selection sorting \n 2. for Bubble sorting");
			System.out.println("\n 3.for Sequential searching \n 4. for binary searching");
			System.out.println("5. to exit \n 6.for shellSorting");
			Option = input.nextInt();
			
			switch(Option){
				
				case 1:{
					
					SelectionSorting();
					View();
				
				}break;
				
				case 2:{
					
					BubbleSort();
					View();
				
				}break;
				
				case 3:{
				
					SequentialSearch();
				
				}break;
				
				case 4:{
				
				BinarySearch();
				
				}break;
				
				case 5:{
				
					System.exit(0);
				}break;
				
				case 6:{
				
					shellSort();
					View();
				}break;
				default:{
					
					System.out.print("Wrong Entry retry");
				}
			}
		}
	}
}	