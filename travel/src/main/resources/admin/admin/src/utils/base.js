const base = {
    get() {
        return {
            url : "http://localhost:8080/travel/",
            name: "travel",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/travel/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "西北旅游服务平台"
        } 
    }
}
export default base
