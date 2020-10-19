package �ڷᱸ��;

import java.util.Scanner;

class IntQueue {
	private int max; // ť �뷮
	private int front; // ù ��° ��� Ŀ��
	private int rear; // ������ ��� Ŀ��
	private int num; // ���� ������ ��
	private int[] que; // ť ��ü

	// ���� �� ���� : ť�� �������
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// ���� �� ���� : ť�� ���� ��
	public class OverFlowIntQueueException extends RuntimeException {
		public OverFlowIntQueueException() {
		}
	}

	// ������
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public int enque(int x) throws OverFlowIntQueueException {
		if (num >= max)
			throw new OverFlowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return idx;
		}
		return -1;
	}

	// ť�� ���
	public void clear() {
		num = front = rear = 0;
	}

	// ť�� �뷮�� ��ȯ
	public int capacity() {
		return max;
	}

	// ť�� �׿� �ִ� ������ ���� ��ȯ
	public int size() {
		return num;
	}

	// ť�� ��� �ֳ���?
	public boolean isEmpty() {
		return num <= 0;
	}

	// ť�� ���� á����?
	public boolean isFull() {
		return num >= max;
	}

	// ť ���� ��� �����͸� ����Ʈ -> ���� ������ ���
	public void dump() {
		if (num <= 0)
			System.out.println("ť�� ��� �ֽ��ϴ�.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}
}

public class ť {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue s = new IntQueue(64);

		while (true) {
			System.out.println("���� ������ �� : " + s.size() + " / " + s.capacity());
			System.out.println("1.��ť 2.��ť 3.��ũ 4.���� 5.����");
			int menu = sc.nextInt();

			if (menu == 5)
				break;

			int x;
			switch (menu) {
			case 1:
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.enque(x);
				} catch (IntQueue.OverFlowIntQueueException e) {
					System.out.println("ť�� ���� á���ϴ�.");
				}
				break;
			case 2:
				try {
					x = s.deque();
					System.out.println("��ť�� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("ť�� ��� �ֽ��ϴ�.");
				}
				break;
			case 4:
				s.dump();
				break;
			}

		}

	}

}
