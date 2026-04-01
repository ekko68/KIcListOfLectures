//1.gulp에 대한 모듈을 전부 불러오기-> import->es6 ->es5으로 코딩
var gulp = require('gulp');//require('불러올 패키지명')
var ts = require('gulp-typescript');//gulp에서 typescript사용해주는 패키지(모듈)
//컴파일 버전 버전을 지정 es5 or es6 target(자바스크립트버전 지정)
//noImplicitAny ->type을 쓰지 않으면 경고메세지를 출력하겠다.
var tsProject = ts.createProject({'target':'es5','noImplicitAny':true});
var sourcemaps = require('gulp-sourcemaps');//소스코드의 위치를 설정할때 파일 기록
var webserver = require('gulp-webserver');//웹서버
var livereload = require('gulp-livereload');//변경된 사항 재로드하기위해 필요

//2.gulp를 이용해서 자동적으로 컴파일->코드를 수정->자동으로 반영->웹에서 출력->순서대로 실행
//작업(task) 설정(1.작업내부 구분자 문자열,실행시킬 콜백함수 지정->1) 웹서버를 가동->포트번호(9400)
gulp.task('server',function(){
     return gulp.src('./') //src함수=>작업영역을 설정할때(1.경로,2.옵션)
     .pipe(webserver({port:9400}));//gulp서버를 가동시키는데 포트번호는 9400 지정
});

//2) 컴파일할 파일,실행할 파일의 위치를 지정
gulp.task('scripts',function(){
      // "src/**/*.ts"       //src/let/let.ts, src/const/const.ts
      var tsResult=gulp.src("src/*.ts")
      .pipe(sourcemaps.init()) //소스코드의 위치를 기록하기위해서 소스맵을 생성
      .pipe(tsProject());//생성
    return tsResult.js.pipe(sourcemaps.write())//js파일에 기록(컴파일및 관련정보)
                      .pipe(gulp.dest('dist'));//목적지폴더(dist폴더에 ) js파일을 저장
});

//3. 변경된 소스를 다시 읽어들여서 다시 반영하라
gulp.task('watch',function(){
       livereload.listen();//읽어들일 준비
       //1.경로및 파일확장자 지정,2.옵션(다시 실행시킬 task이름을 부여)
       gulp.watch('src/*.ts',['scripts']);
       //2.js파일을 웹상에서도 변화가 있을때마다(F5(새로고침))->다시 읽어들여라
       gulp.watch('dist/*.js').on('change',livereload.changed)
});

//4.gulp를 실행시킬때 기본적으로 작동되는 순서를 지정->배열표시
//실행시키는 방법->typescript>gulp 실행시킬 task작업명 
//                          >gulp   X ->default task작업이 작동
gulp.task('default',['server','scripts','watch'])



