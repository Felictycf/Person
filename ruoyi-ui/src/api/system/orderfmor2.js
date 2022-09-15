import request from '@/utils/request'

// 查询订单信息列表
export function listOrderfmor2(query) {
  return request({
    url: '/system/orderfmor2/list',
    method: 'get',
    params: query
  })
}

// 查询订单信息详细
export function getOrderfmor2(onum) {
  return request({
    url: '/system/orderfmor2/' + onum,
    method: 'get'
  })
}

// 新增订单信息
export function addOrderfmor2(data) {
  return request({
    url: '/system/orderfmor2',
    method: 'post',
    data: data
  })
}

// 修改订单信息
export function updateOrderfmor2(data) {
  return request({
    url: '/system/orderfmor2',
    method: 'put',
    data: data
  })
}

// 删除订单信息
export function delOrderfmor2(onum) {
  return request({
    url: '/system/orderfmor2/' + onum,
    method: 'delete'
  })
}
