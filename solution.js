// 문제풀이 접근이 잘못된듯하여 말할수있는 단어를 안만들고
// 입력받은 배열을 돌며 4단어로 스플릿하고 다시 문자열로
// 합쳐서 ""이면 answer++해서 풀엇는데
// 밑에 재귀로 단어만들때 브레이크가 안먹히네요

let baby = ["aya", "ye", "woo", "ma", ""];
let babyable = [];
let count = 0;

function make(arr) {
    for (let a of arr) {
        for (let i = 0; i < baby.length; i++) {
            if (a != baby[i]) babyable[count++] = a + baby[i];
            if (count < 5*5*5*5) make(babyable);

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

