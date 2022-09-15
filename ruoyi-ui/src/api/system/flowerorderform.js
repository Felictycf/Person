import request from '@/utils/request'

// 查询鲜花订单信息列表
export function listFlowerorderform(query) {
  return request({
    url: '/system/flowerorderform/list',
    method: 'get',
    params: query
  })
}

// 查询鲜花订单信息详细
export function getFlowerorderform(onum) {
  return request({
    url: '/system/flowerorderform/' + onum,
    method: 'get'
  })
}

// 新增鲜花订单信息
export function addFlowerorderform(data) {
  return request({
    url: '/system/flowerorderform',
    method: 'post',
    data: data
  })
}

// 修改鲜花订单信息
export function updateFlowerorderform(data) {
  return request({
    url: '/system/flowerorderform',
    method: 'put',
    data: data
  })
}

// 删除鲜花订单信息
export function delFlowerorderform(onum) {
  return request({
    url: '/system/flowerorderform/' + onum,
    method: 'delete'
  })
}
