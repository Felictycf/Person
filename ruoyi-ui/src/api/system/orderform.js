import request from '@/utils/request'

// 查询订单信息列表
export function listOrderform(query) {
  return request({
    url: '/system/orderform/list',
    method: 'get',
    params: query
  })
}

// 查询订单信息详细
export function getOrderform(onum) {
  return request({
    url: '/system/orderform/' + onum,
    method: 'get'
  })
}

// 新增订单信息
export function addOrderform(data) {
  return request({
    url: '/system/orderform',
    method: 'post',
    data: data
  })
}

// 修改订单信息
export function updateOrderform(data) {
  return request({
    url: '/system/orderform',
    method: 'put',
    data: data
  })
}

// 删除订单信息
export function delOrderform(onum) {
  return request({
    url: '/system/orderform/' + onum,
    method: 'delete'
  })
}
