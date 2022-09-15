import request from '@/utils/request'

// 查询职工薪酬信息列表
export function listPersonManger(query) {
  return request({
    url: '/system/personManger/list',
    method: 'get',
    params: query
  })
}

// 查询职工薪酬信息详细
export function getPersonManger(staffid) {
  return request({
    url: '/system/personManger/' + staffid,
    method: 'get'
  })
}

// 新增职工薪酬信息
export function addPersonManger(data) {
  return request({
    url: '/system/personManger',
    method: 'post',
    data: data
  })
}

// 修改职工薪酬信息
export function updatePersonManger(data) {
  return request({
    url: '/system/personManger',
    method: 'put',
    data: data
  })
}

// 删除职工薪酬信息
export function delPersonManger(staffid) {
  return request({
    url: '/system/personManger/' + staffid,
    method: 'delete'
  })
}
