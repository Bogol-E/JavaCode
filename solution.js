let baby = ["aya", "ye", "woo", "ma", ""];
let babyable = [];
let count = 0;

function make(arr) {
    for (let a of arr) {
        for (let i = 0; i < baby.length; i++) {
            if (a != baby[i]) babyable[count++] = a + baby[i];
            if (count > 5*5*5*5) break;
            make(babyable);

        }
    }
}
make(baby);
babyable = new Set(babyable);


function solution(babbling) {
    var answer = 0;
    for (let t of babbling) {
        for (let k of babyable) {
            if (t == k) answer++;
        }
    }
    return answer;
}

