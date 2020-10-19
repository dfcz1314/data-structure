package 자료구조;

import java.util.*;

import 자료구조.IntStack.OverFlowINtStackException;

class IntStack {
	int max;
	int ptr;
	int[] stk;

	// 실행 시 예외 : 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// 실행시 예외 : 스택이 가득 참
	public class OverFlowINtStackException extends RuntimeException {
		public OverFlowINtStackException() {
		}
	}
	
	//생성자 배열 생성
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// 값 푸쉬
	public int push(int x) throws OverFlowINtStackException {
		if (ptr >= max)
			throw new OverFlowINtStackException();
		return stk[ptr++] = x;
	}

	//값 제거 와 반환
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	// 제일 꼭대기 값 반환
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
	// 매개변수의 값이 있는지 찾음 있으면 인덱스 없으면 -1 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x)
				return i;
		}
		return -1;
	}

	// 스택에 쌓여 있는 데이터 삭제
	public void clear() {
		ptr = 0;
	}
	//스택의 전체 크기 반환
	public int capacity() {
		return max;
	}
	//지금까지 쌓여있는 데이터 수 반환
	public int size() {
		return ptr;
	}
	// 스택이 비어있는지 여부를 반환
	public boolean isEmpty() {
		return ptr <= 0;
	}
	// 스택이 가득 차 있는지 여부를 반환
	public boolean isFull() {
		return ptr >= max;
	}
	
	// 스택 안에 모든 데이터 반환
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}

public class 스택 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0)종료 : ");
			int menu = sc.nextInt();
			if (menu == 0)
				break;
			int x;
			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverFlowINtStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2:
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			case 4:
				s.dump();
				break;
			}
		}

	}

}
