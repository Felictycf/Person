import request from '@/utils/request'

// 查询统计信息列表
export function listTongji(query) {
  return request({
    url: '/system/tongji/list',
    method: 'get',
    params: query
  })
}

// 查询统计信息详细
export function getTongji(id) {
  return request({
    url: '/system/tongji/' + id,
    method: 'get'
  })
}

// 新增统计信息
export function addTongji(data) {
  return request({
    url: '/system/tongji',
    method: 'post',
    data: data
  })
}

// 修改统计信息
export function updateTongji(data) {
  return request({
    url: '/system/tongji',
    method: 'put',
    data: data
  })
}

// 删除统计信息
export function delTongji(id) {
  return request({
    url: '/system/tongji/' + id,
    method: 'delete'
  })
}
