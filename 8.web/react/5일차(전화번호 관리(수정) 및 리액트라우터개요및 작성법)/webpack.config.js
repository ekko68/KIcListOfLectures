module.exports = {
    entry: './src/index.js',  /* 불러오는 처음 시작위치(자바스크립트파일)  */

    output: { /* 최종적으로 화면에 출력 */
        path: __dirname + '/public/',  /* 메인페이지의 위치 */
        filename: 'bundle.js' /* js파일들이 묶어서 만들어진 최종파일 */
    },

    devServer: {  /* 개발 서버의 설정 부분 */
        inline: true,
        port: 7777,  /* 포트번호 */
        //추가
        historyApiFallback: true , /* reload했을때 경로 찾아가는 옵션*/
        contentBase: __dirname + '/public/' /* index.html */
    },

    module: {
            loaders: [  
                {
                    test: /\.js$/,  /* 불러오는 자바스크립트 파일 확장자*/
                    loader: 'babel-loader', /* 소스코딩 변경->반영 */
                    exclude: /node_modules/, /* 불러오는 모듈 배제위치 */
                    query: {
                        cacheDirectory: true,
                        presets: ['es2015','stage-0','react'] /* es6, react */
                    }
                }
            ]
        }
};