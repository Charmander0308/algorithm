package algorithm_logic.TIL.linkedList.연결큐;

public class LinkedQueue {
	Node front;	//첫번째 노드(삭제)
	Node rear;	//마지막 노드(추가)
	
	//공백 확인
	public boolean isEmpty() {
		return front == null && rear == null; 
	}
	
	//peek(조회)
	public Integer peek() {
		if(isEmpty()) return null;
		return front.data;
	}
	
	//삽입!
	//1. 공백 상태에서의 삽입
	//2. 이미 원소가 존재하는 상태에서의 삽입
	public void enQueue(int data) {
		//노드 생성
		Node node = new Node(data);
		//1. 공백이면
		if(isEmpty()) front = rear = node;
		//2. 원소가 있다면
		else {
			rear.link = node;	//냅다 옮기면 안되고 링크부터 옮겨야됨
			rear = node;		//rear = rear.link;
		}
	}
	
	//삭제
	//1. 공백 상태에서의 삭제
	//2. 그냥 삭제
	public Integer deQueue() {
		if(isEmpty()) return null;
		int data = front.data;
		front = front.link;
		if(front == null) rear = null;
		return data;
	}

}
