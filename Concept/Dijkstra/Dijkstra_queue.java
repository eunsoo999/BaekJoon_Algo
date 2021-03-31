package week5;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
TC1.
- 1부터 시작, 6개의 정점, 9개의 간선
1 6 9
1 2 8
1 3 1
1 4 2
3 2 5
3 4 2
4 5 3
4 6 5
5 6 1
6 1 5
*/
// 우선순위큐 사용 다익스트라 알고리즘
public class Dijkstra_queue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt(); // 시작 정점
		int V = sc.nextInt(); // 정점개수
		int E = sc.nextInt(); // 간선개수
		
		//초기화
		ArrayList<Node>[] graph = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//그래프 입력(출발지, 도착지, 가중치)
		for (int i = 0; i < E; i++) {
			graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		// dijkstra
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[V+1]; // 시작점으로부터 해당 정점까지의 거리배열

		// 거리 배열 INF로 초기화
		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0; // 출발지-> 출발지의 거리는 0
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node edge = pq.poll();
			if (distance[edge.v] < edge.w) {
				continue;
				// 여기까지 오는 거리가, 이전에 이미 왔던 경로보다 크면 X
			}
			
			for (Node next : graph[edge.v]) {
				int next_distance = edge.w + next.w;
				
				if (next_distance < distance[next.v]) {
					distance[next.v] = next_distance;
					pq.add(new Node(next.v, next_distance));
				}
			}
		}
		
		// start정점으로부터 각 정점까지의 거리 출력
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.print("X ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}
	}
}
class Node implements Comparable<Node> {
	int v;
	int w;
	
	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.w - o.w; // +면 자리바꾸기 (오름차순)
	}
}
