import request from '@/utils/request'

// 查询学生情绪信息列表
export function listStudent(query) {
  return request({
    url: '/system/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生情绪信息详细
export function getStudent(id) {
  return request({
    url: '/system/student/' + id,
    method: 'get'
  })
}

// 新增学生情绪信息
export function addStudent(data) {
  return request({
    url: '/system/student',
    method: 'post',
    data: data
  })
}

// 修改学生情绪信息
export function updateStudent(data) {
  return request({
    url: '/system/student',
    method: 'put',
    data: data
  })
}

// 删除学生情绪信息
export function delStudent(id) {
  return request({
    url: '/system/student/' + id,
    method: 'delete'
  })
}
