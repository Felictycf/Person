import request from '@/utils/request'

// 查询鲜花订单地址管理列表
export function listKuowuID(query) {
  return request({
    url: '/system/kuowuID/list',
    method: 'get',
    params: query
  })
}

// 查询鲜花订单地址管理详细
export function getKuowuID(huowuId) {
  return request({
    url: '/system/kuowuID/' + huowuId,
    method: 'get'
  })
}

// 新增鲜花订单地址管理
export function addKuowuID(data) {
  return request({
    url: '/system/kuowuID',
    method: 'post',
    data: data
  })
}

// 修改鲜花订单地址管理
export function updateKuowuID(data) {
  return request({
    url: '/system/kuowuID',
    method: 'put',
    data: data
  })
}

// 删除鲜花订单地址管理
export function delKuowuID(huowuId) {
  return request({
    url: '/system/kuowuID/' + huowuId,
    method: 'delete'
  })
}
