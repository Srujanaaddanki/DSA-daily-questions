class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder title=new StringBuilder();

        while(columnNumber>0){
            columnNumber--;
            int r=columnNumber%26;

            title.append((char)(r+'A'));

            columnNumber=columnNumber/26;
        }
        return title.reverse().toString();
    }
}
