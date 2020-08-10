import java.util.Scanner;
import java.util.Stack;

public class infixEvaluation {

    public static int precedenceOf(char op){
        if(op=='+' || op=='-'){
            return 1;
        }else if(op=='*' || op=='/'){
            return 2;
        }
        return -1;
    }

    public static int calc(int v1,int v2,char op){
        if(op=='+'){
            return v1+v2;
        }else if(op=='-'){
            return v1-v2;
        }else if(op=='*'){
            return v1*v2;
        }else if(op=='/'){
            return v1/v2;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)){
                operand.push(ch-'0');
            }else if(ch=='('){
                operators.push(ch);
            }else if(ch==')'){
                while(operators.peek()!='('){
                    int v2=operand.pop();
                    int v1=operand.pop();
                    char op=operators.pop();
                    int ans = calc(v1,v2,op);
                    operand.push(ans);
                }
                operators.pop();
            }else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                while(operators.size()>0 && operators.peek()!='(' && precedenceOf(operators.peek())>=precedenceOf(ch)){
                    int v2=operand.pop();
                    int v1=operand.pop();
                    char op=operators.pop();
                    int ans = calc(v1,v2,op);
                    operand.push(ans);
                }
                operators.push(ch);
            }

            else continue;
        System.out.println(operand+" "+operators);       
        }
        while(operators.size()>0){
            int v2=operand.pop();
            int v1=operand.pop();
            char op=operators.pop();
            int ans = calc(v1,v2,op);
            operand.push(ans);
        }
        System.out.println(operand.pop());     
        sc.close();  
    }
}