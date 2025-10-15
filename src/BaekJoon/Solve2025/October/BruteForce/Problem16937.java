package BaekJoon.Solve2025.October.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem16937 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        List<Sticker> stickers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ih = Integer.parseInt(st.nextToken());
            int iw = Integer.parseInt(st.nextToken());
            if ((ih > h && ih > w) || (iw > w && iw > h)) continue;
            stickers.add(new Sticker(ih, iw));
        }
        System.out.print(search(stickers, h, w));

        br.close();
    }

    private int search(List<Sticker> stickers, int h, int w) {
        int res = 0;
        for (int i = 0; i < stickers.size(); i++) {
            Sticker sticker = stickers.get(i);
            int size = sticker.h * sticker.w;
            int tmpH = h - sticker.h;
            int tmpW = w - sticker.w;
            if (tmpH >= 0 && tmpW >= 0) {
                res = Math.max(res, searchNext(stickers, i, h, w, tmpH, tmpW, size));
            }

            tmpH = h - sticker.w;
            tmpW = w - sticker.h;
            if (tmpH >= 0 && tmpW >= 0) {
                res = Math.max(res, searchNext(stickers, i, h, w, tmpH, tmpW, size));
            }
        }
        return res;
    }
    private int searchNext(List<Sticker> stickers, int idx, int th, int tw, int h, int w, int size) {
        int res = 0;
        for (int i = idx + 1; i < stickers.size(); i++) {
            Sticker sticker = stickers.get(i);
            int tmpSize = sticker.h * sticker.w;
            if ((sticker.h <= h && sticker.w <= tw) || (sticker.h <= th && sticker.w <= w)
            || (sticker.w <= h && sticker.h <= tw) || (sticker.w <= th && sticker.h <= w)) {
                res = Math.max(res, size + tmpSize);
            }
        }
        return res;
    }

    class Sticker {
        int h, w;
        public Sticker(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
