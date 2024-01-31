#include <bits/stdc++.h>
#include <string>
#define int long long
using namespace std;
signed main(){
    int n, q;
    cin >> n >> q;
    string s;
    cin>> s;
    map<pair<int, int>, vector<int>> time;
    map<pair<int, int>, vector<int>> rtime;
    int x = 0, y = 0;
    
    vector<pair<int, int>> pts(n + 1);
    pts[0] = {0, 0};
    time[pts[0]].push_back(0);

    for(int i = 0; i < n; i++){
        if(s[i] == 'L')
            x--;
        else if(s[i] == 'R')
            x++;
        else if(s[i] == 'U')
            y++;
        else y--;

        pts[i + 1] = {x, y};
        time[pts[i + 1]].push_back(i + 1);
    }

    x = 0, y = 0;
    vector<pair<int, int>> pts2(n + 2);
    pts2[n + 1] = {0, 0};
    rtime[pts[n + 1]].push_back(n + 1);
    for(int i = n - 1; i >= 0; i--){
        if(s[i] == 'L')
            x--;
        else if(s[i] == 'R')
            x++;
        else if(s[i] == 'U')
            y++;
        else y--;

        pts2[i + 1] = {x, y};
        rtime[pts2[i + 1]].push_back(i + 1);
    }

    for(auto &v : rtime){
        sort(rtime[v.first].begin(), rtime[v.first].end());
    }

    while(q-- > 0){
        int x, y, l, r;
        cin >> x >> y >> l >> r;
        int f = 0;
        auto it = time[{x,y}].begin();
        if(it != time[{x, y}].end() && (*it) < l){
            f = 1;
        }

        it = time[{x, y}].end();
        if(it != time[{x, y}].begin() && (*--it) > r){
            f = 1;
        }

        x -= pts[l - 1].first;
        y -= pts[l - 1].second;

        x += pts2[r + 1].first;
        y += pts2[r + 1].second;

        it = upper_bound(rtime[{x, y}].begin(), rtime[{x, y}].end(), l - 1);
        if(it != rtime[{x, y}].end() and (*it) <= r)
            f = 1;

        if(f)
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }

    return 0;
}