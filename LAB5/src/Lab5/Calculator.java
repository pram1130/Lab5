package Lab5;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calculator {

	protected Shell shlCalculator;
	private Text text;
	private Button btn8;
	private Button btn9;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn0;
	private Button btnadd;
	private Button btnsub;
	private Button btnmul;
	private Button btndiv;
	private Button btneq;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCalculator.open();
		shlCalculator.layout();
		while (!shlCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	public ArrayList<Character> arr = new ArrayList<Character>();
	public String str;
	public int opA, opB;
	public char operator;
	public int ans;
	public int pointer;
	public boolean eq = false;
	private Text text_ans;
	public void cal(char num) {
		if(eq == true) {
			arr.clear();
			text.setText("");
			text_ans.setText("");
			eq = false;
		}
		arr.add(num);
		text.append(Character.toString(num));
		System.out.println(arr);
	}
	
	public void summary() {
		str = arr.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");
		int pointer = str.indexOf(operator);
        int opA , opB;
        opA = Integer.valueOf(str.substring(0, pointer));
        opB = Integer.valueOf(str.substring(pointer + 1, str.length()));
        switch(operator){
        case '+' :
        	ans = opA + opB;
        	break;
        case '-' :
        	ans = opA - opB;
        	break;
        case '*' :
        	ans = opA * opB;
        	break;
        case '/' :
        	if(opB != 0) {
        		text_ans.append(String.valueOf((float)opA / (float)opB));
        	} else {
        		text_ans.append("Syntax Error");
        		
        	}
        	break;
        }
        if(operator != '/') {
        	text_ans.append(String.valueOf(ans));
        }
	}
	
	protected void createContents() {
		shlCalculator = new Shell();
		shlCalculator.setSize(310, 380);
		shlCalculator.setText("Miy's Calculator");
		
		text = new Text(shlCalculator, SWT.BORDER);
		text.setBounds(10, 10, 274, 44);
		
		text_ans = new Text(shlCalculator, SWT.BORDER);
		text_ans.setBounds(10, 60, 274, 44);
		
		btn0 = new Button(shlCalculator, SWT.NONE);
		btn0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty()) {
					cal('0');
				}
			}
		});
		btn0.setText("0");
		btn0.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn0.setBounds(10, 284, 162, 50);
		
		btn1 = new Button(shlCalculator, SWT.NONE);
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('1');
			}
		});
		btn1.setText("1");
		btn1.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn1.setBounds(10, 228, 50, 50);
		
		btn2 = new Button(shlCalculator, SWT.NONE);
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('2');
			}
		});
		btn2.setText("2");
		btn2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn2.setBounds(66, 228, 50, 50);
		
		btn3 = new Button(shlCalculator, SWT.NONE);
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('3');
			}
		});
		btn3.setText("3");
		btn3.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn3.setBounds(122, 228, 50, 50);
		
		btn4 = new Button(shlCalculator, SWT.NONE);
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('4');
			}
		});
		btn4.setText("4");
		btn4.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn4.setBounds(10, 172, 50, 50);
		
		btn5 = new Button(shlCalculator, SWT.NONE);
		btn5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('5');
			}
		});
		btn5.setText("5");
		btn5.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn5.setBounds(66, 172, 50, 50);
		
		btn6 = new Button(shlCalculator, SWT.NONE);
		btn6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('6');
			}
		});
		btn6.setText("6");
		btn6.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn6.setBounds(122, 172, 50, 50);
		
		Button btn7 = new Button(shlCalculator, SWT.NONE);
		btn7.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('7');
			}
		});
		btn7.setBounds(10, 116, 50, 50);
		btn7.setText("7");
		
		btn8 = new Button(shlCalculator, SWT.NONE);
		btn8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('8');
			}
		});
		btn8.setText("8");
		btn8.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn8.setBounds(66, 116, 50, 50);
		
		btn9 = new Button(shlCalculator, SWT.NONE);
		btn9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('9');
			}
		});
		btn9.setText("9");
		btn9.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn9.setBounds(122, 116, 50, 50);
		
		btnadd = new Button(shlCalculator, SWT.NONE);
		btnadd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('+');
					operator = '+' ;
				}
			}
		});
		btnadd.setText("+");
		btnadd.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnadd.setBounds(178, 116, 50, 50);
		
		btnsub = new Button(shlCalculator, SWT.NONE);
		btnsub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('-');
					operator = '-' ;
				}
			}
		});
		btnsub.setText("-");
		btnsub.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnsub.setBounds(234, 116, 50, 50);
		
		btnmul = new Button(shlCalculator, SWT.NONE);
		btnmul.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('*');
					operator = '*' ;
				}
			}
		});
		btnmul.setText("*");
		btnmul.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btnmul.setBounds(178, 172, 50, 50);
		
		btndiv = new Button(shlCalculator, SWT.NONE);
		btndiv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('/');
					operator = '/' ;
				}
			}
		});
		btndiv.setText("/");
		btndiv.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btndiv.setBounds(234, 172, 50, 50);
		
		btneq = new Button(shlCalculator, SWT.NONE);
		btneq.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					eq = true;
					summary();
				}
			}
		});
		btneq.setText("=");
		btneq.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btneq.setBounds(178, 228, 106, 106);
		

	}
}