class ATM {
    int arr[];
    public ATM() {
        arr = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<banknotesCount.length;i++)
            {
                arr[i]+=banknotesCount[i];
            }
    }
    
    public int[] withdraw(int amount) {
        int nums[]=new int[5];
        nums[4]=(int)Math.min(arr[4],amount/500);
        amount-=nums[4]*500;
        nums[3]=(int)Math.min(arr[3],amount/200);
        amount-=nums[3]*200;
        nums[2]=(int)Math.min(arr[2],amount/100);
        amount-=nums[2]*100;
        nums[1]=(int)Math.min(arr[1],amount/50);
        amount-=nums[1]*50;
        nums[0]=(int)Math.min(arr[0],amount/20);
        amount-=nums[0]*20;
        
        if(amount!=0)return new int[]{-1};
        for(int i=0;i<5;i++)
            {
                int num=arr[i]-nums[i];
                if(num<0)return new int[]{-1};
            }
        for(int i=0;i<5;i++)
            {
                arr[i]-=nums[i];
            }
        return nums;
    }
    
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */