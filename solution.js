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

// 코드 읽어보니까 재귀로 돌면서 말할 수 있는 모든 경우의 수를 뽑고
// set으로 중복은 제거한 후에 테스트케이스 돌면서 확인하려고 하신 것 같습니다.
// 우선 실행 도중에 프로그램이 죽는 이유는 재귀로 구현 시에는 스택의 용량에 제한이 있습니다.
// 여기서는 스택의 최대 용량을 초과해서 실행이 중단되는 것으로 보입니다. 
// 모든 경우의 수를 구하고 테스트케이스와 비교하는 것이 아니라 
// 테스트케이스를 하나씩 돌며 조건과 부합하는지 검사해 나가는 것이 올바른 풀이법이라고 생각됩니다.
// 좀 더 고민해 보신 후에 다시 물어보신다면 제가 푼 방법을 설명해 드리겠습니다. 
