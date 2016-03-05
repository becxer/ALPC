/* Apple script 예제
// 스크립트 내용
tell application "System Events"
        set frontApp to name of first application process whose frontmost is true
end tell
tell application frontApp
        if the (count of windows) is not 0 then
                set window_name to name of front window
        end if
end tell

// 응답 로그
tell application "System Events"
        get name of application process 1 whose frontmost = true
                --> "Script Editor"
end tell
tell application "Script Editor"
        count every window of current application
                --> 5
        get name of window 1
                --> "무제.scpt"
end tell
결과:
"무제.scpt"
*/

// 시스템 이벤트 객체
var systemEvent = Application('System Events');
// 실행중인 프로세스 리스트
var procs = systemEvent.processes;
// 사용자가 실행한 프로세스 저장할 딕셔너리
var usingList = {};
var totalCount = 0;

// 사용중인 프로그램 정보 획득
var proc = procs[procs.frontmost().indexOf(true)];
var procName = proc.name();
if (usingList[procName] === undefined) usingList[procName] = 1;
else usingList[procName] += 1;

for (var elem in usingList) {
        elem + ' : ' + usingList[elem];
