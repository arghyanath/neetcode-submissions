class Node {
	int data;
	Node next;
	Node prev;

	public Node(int data) {
		this.data = data;
		this.next = next;
	}
}

class Queue {
		Node head = null;
	

		public void add(int data) {
			Node newNode = new Node(data);

			if(head == null) {
				head = newNode;
				return;
			}

			
			if(head.data <= data) {
				newNode.next = head;
				head = newNode;
				return;
			}
				
			if (head.next == null) {
				if(head.data > data) {
					head.next = newNode;
				}
				return;
			}
			

			Node p = head;

			while(p.next != null) {
				if(p.next.data <= data) {

					break;
				}
				p = p.next;
			}

			newNode.next = p.next;
			p.next = newNode;
		}

		public void delete(int data) {
			if(head == null) {
				return;
			}
			if(head.data == data) {
				head = head.next;
				return;
			}

			Node p = head;

			while (p.next != null) {
				if(p.next.data == data) {

					break;
				}
				p = p.next;
			}
			p.next = p.next.next;
		}

		public void show() {
			Node p = head;

			while(p != null) {
				System.out.print(p.data + "->");
				p = p.next;
			}
			System.out.println("null");
		}
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n - k + 1];
		
		Queue q = new Queue();

		int i = 0;
		int j = 0;
        int idx = 0;

		while (j < nums.length) {

			q.add(nums[j]);
			

			if(j - i + 1 < k) {
				j++;
			}
			else if(j - i + 1 == k) {
				res[idx++] =  q.head.data;

				q.delete(nums[i]);

				i++;
				j++;
			}
		}
        

		return res;
    }
}
