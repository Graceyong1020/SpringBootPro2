async function get1(bno) {
    const result = await axios.get(`/replies/list/${bno}`);

    // console.log(result);

    return result;
}

// 댓글 목록 처리
async function getList({bno, page, size, goLast}) {
    const result = await axios.get(`/replies/list/${bno}`, {params: {page, size}})

    if(goLast) {
        const total = result.data.total
        const lastPage = parseInt(Math.ceil(total / size))
        return getList({bno:bno, page:lastPage, size:size})
    }
    return result.data
}

// 댓글 등록 처리: 파라미터를 JS객체로 받아서 axios.post() 이용하여 전달
async function addReply(replyObj) {
    const response = await axios.post('/replies', replyObj)
    return response.data
}

// 댓글 조회(GET), 수정(PUT)
async function getReply(rno) {
    const response = await axios.get(`/replies/${rno}`)
    return response.data
}
async function modifyReply(replyObj) {
    const response = await axios.put(`/replies/${replyObj.rno}`, replyObj)
    return response.data
}
// 댓글 삭제 처리
async function removeReply(rno) {
    const response = await axios.delete(`/replies/${rno}`)
    return response.data
}
