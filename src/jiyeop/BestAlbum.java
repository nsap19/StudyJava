package jiyeop;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BestAlbum {
	static class MusicInfo implements Comparable<MusicInfo>{
		String genres;
		int play;
		int idnum;
		public MusicInfo() {
		}
		public MusicInfo(String genres, int play, int idnum) {
			super();
			this.genres = genres;
			this.play = play;
			this.idnum = idnum;
		}
		/**객체 배열 정렬
		 * comparable 인터페이스 사용
		 * */
		@Override
		public int compareTo(MusicInfo o) {
			if(this.play<o.play) {
				return 1;
			}
			else if(this.play>o.play) {
				return -1;
			}
			else
			return 0;
		}
		
		
	}
	static class bestalbum {
	    public int[] solution(String[] genres, int[] plays) {
	    	int[] answer;
	        HashMap<String, Integer> HM = new HashMap<>();
	        /**저장*/
	        for (int i = 0; i < genres.length; i++) {
				HM.put(genres[i], HM.getOrDefault(genres[i], 0)+plays[i]);
			}
	        //장르 순서를 저장할 array
	        ArrayList<String> g_order = new ArrayList<String>();
	        /**선정*/
	        while(HM.size()!=0) {
	        	int max = -1;
	        	String Mkey="";
	        	for (String key : HM.keySet()) {
					int temp = HM.get(key);
					if(temp>max) {
						max = temp;
						Mkey = key;
					}
				}
	        	g_order.add(Mkey);
	        	HM.remove(Mkey);
	        }
	        /**장르 선정 후 노래 선정
	         * 처음엔 장르 재생된 노래를 위주로 구성했는데 
	         * 고유 번호 때문에 케이스 몇개가 틀리는것 같다.
	         * 저장을 장르 재생 고유번호 다 저장해보자.*/
	        ArrayList<MusicInfo> g_music = new ArrayList<MusicInfo>();
	        for (String g : g_order) {
	        	ArrayList<MusicInfo> list = new ArrayList<MusicInfo>();
	        	for (int i = 0; i < genres.length; i++) {
					if(genres[i].equals(g)) {
						list.add(new MusicInfo(g,plays[i],i));
					}
				}
	        	
	        	Collections.sort(list);
	        	//정렬을 해보자
	        	g_music.add(list.get(0));
	        	if(list.size()!=1) {
	        		g_music.add(list.get(1));
	        	}
	        	list.removeAll(list);
			}
	       //출력
	        answer = new int[g_music.size()];
	        for(int i=0;i<g_music.size();i++) {
	        	answer[i] = g_music.get(i).idnum;
	        	 
	        }
	        
	        System.out.println(Arrays.toString(answer));
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		/**속한 노래가 많이 재생된 장르를 먼저 수록
		 * 장르 내에서 많이 재생된 노래를 먼저 수록
		 * 장르내에서 재생횟수가 같으면 고유 번호가 낮은 노래를 먼저 수록
		 * 각 장르당 2곡만 수록*/
		String[] genres = {"classic", "pop", "classic", "classic" , "pop"};
		int[] plays = {500,600,150,800,2500};
		bestalbum sol = new bestalbum();
		sol.solution(genres, plays);
		

	}

}
