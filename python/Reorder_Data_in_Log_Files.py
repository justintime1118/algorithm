class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        let_logs, num_logs = list(), list()
        # 문자로그와 숫자로그를 나눠서 담아둔다
        for log in logs:
            if log.split()[1].isalpha():
                let_logs.append(log)
            else:
                num_logs.append(log)
        
        # 문자로그 정렬
        let_logs.sort(key=lambda x : (x.split()[1:], x.split()[0]))

        # 문자로그와 숫자로그 병합
        return let_logs + num_logs