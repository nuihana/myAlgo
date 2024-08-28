package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2621 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hand.add(new Card(st.nextToken(), st.nextToken()));
        }

        hand.sort((c1, c2) -> c1.num - c2.num);

        int res = 0;
        if (isStraightFlush(hand) > 0) {
            res = 900 + isStraightFlush(hand);
        } else if (isFourCard(hand) > 0) {
            res = 800 + isFourCard(hand);
        } else if (isFullHouse(hand) > 0) {
            res = 700 + isFullHouse(hand);
        } else if (isFlush(hand) > 0) {
            res = 600 + isFlush(hand);
        } else if (isStraight(hand) > 0) {
            res = 500 + isStraight(hand);
        } else if (isTriple(hand) > 0) {
            res = 400 + isTriple(hand);
        } else if (isDoublePair(hand) > 0) {
            res = 300 + isDoublePair(hand);
        } else if (isPair(hand) > 0) {
            res = 200 + isPair(hand);
        } else {
            res = 100 + hand.get(4).num;
        }

        System.out.print(res);

        br.close();
    }

    private int isFlush(List<Card> hand) {
        String color = hand.get(0).color;
        for (Card c : hand) {
            if (!c.color.equals(color)) return -1;
        }
        return hand.get(4).num;
    }

    private int isStraight(List<Card> hand) {
        int num = hand.get(0).num;
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).num != num + i) return -1;
        }
        return hand.get(4).num;
    }

    private int isStraightFlush(List<Card> hand) {
        if (isFlush(hand) < 0 || isStraight(hand) < 0) return -1;
        return hand.get(4).num;
    }

    private int isFourCard(List<Card> hand) {
        int[] nums = new int[10];
        for (Card c : hand) {
            nums[c.num]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (nums[i] == 4) return i;
        }
        return -1;
    }

    private int isTriple(List<Card> hand) {
        int[] nums = new int[10];
        for (Card c : hand) {
            nums[c.num]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (nums[i] == 3) return i;
        }
        return -1;
    }

    private int isPair(List<Card> hand) {
        int[] nums = new int[10];
        for (Card c : hand) {
            nums[c.num]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (nums[i] == 2) return i;
        }
        return -1;
    }

    private int isDoublePair(List<Card> hand) {
        int[] nums = new int[10];
        for (Card c : hand) {
            nums[c.num]++;
        }
        int[] pairs = new int[2];
        int pairCnt = 0;
        for (int i = 1; i <= 9; i++) {
            if (nums[i] == 2) {
                pairs[pairCnt++] = i;
            }
        }

        if (pairCnt == 2) {
            return Math.max(pairs[0], pairs[1]) * 10 + Math.min(pairs[0], pairs[1]);
        } else {
            return -1;
        }
    }

    private int isFullHouse(List<Card> hand) {
        if (isTriple(hand) > 0 && isPair(hand) > 0) return isTriple(hand) * 10 + isPair(hand);
        return -1;
    }

    class Card {
        String color;
        int num;

        public Card(String c, String n) {
            color = c;
            num = Integer.parseInt(n);
        }
    }
}
