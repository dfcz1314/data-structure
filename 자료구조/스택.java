package �ڷᱸ��;

import java.util.*;

import �ڷᱸ��.IntStack.OverFlowINtStackException;

class IntStack {
	int max;
	int ptr;
	int[] stk;

	// ���� �� ���� : ������ ��� ����
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// ����� ���� : ������ ���� ��
	public class OverFlowINtStackException extends RuntimeException {
		public OverFlowINtStackException() {
		}
	}
	
	//������ �迭 ����
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// �� Ǫ��
	public int push(int x) throws OverFlowINtStackException {
		if (ptr >= max)
			throw new OverFlowINtStackException();
		return stk[ptr++] = x;
	}

	//�� ���� �� ��ȯ
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	// ���� ����� �� ��ȯ
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
	// �Ű������� ���� �ִ��� ã�� ������ �ε��� ������ -1 ��ȯ
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x)
				return i;
		}
		return -1;
	}

	// ���ÿ� �׿� �ִ� ������ ����
	public void clear() {
		ptr = 0;
	}
	//������ ��ü ũ�� ��ȯ
	public int capacity() {
		return max;
	}
	//���ݱ��� �׿��ִ� ������ �� ��ȯ
	public int size() {
		return ptr;
	}
	// ������ ����ִ��� ���θ� ��ȯ
	public boolean isEmpty() {
		return ptr <= 0;
	}
	// ������ ���� �� �ִ��� ���θ� ��ȯ
	public boolean isFull() {
		return ptr >= max;
	}
	
	// ���� �ȿ� ��� ������ ��ȯ
	public void dump() {
		if (ptr <= 0)
			System.out.println("������ ��� �ֽ��ϴ�.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}

public class ���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("���� ������ �� : " + s.size() + " / " + s.capacity());
			System.out.print("(1) Ǫ�� (2) �� (3) ��ũ (4) ���� (0)���� : ");
			int menu = sc.nextInt();
			if (menu == 0)
				break;
			int x;
			switch (menu) {
			case 1:
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverFlowINtStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 2:
				try {
					x = s.pop();
					System.out.println("���� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;

			case 4:
				s.dump();
				break;
			}
		}

	}

}
