import request from '@/utils/request'

// 查询人事信息列表
export function listRenshiINFO(query) {
  return request({
    url: '/system/renshiINFO/list',
    method: 'get',
    params: query
  })
}

// 查询人事信息详细
export function getRenshiINFO(staffid) {
  return request({
    url: '/system/renshiINFO/' + staffid,
    method: 'get'
  })
}

// 新增人事信息
export function addRenshiINFO(data) {
  return request({
    url: '/system/renshiINFO',
    method: 'post',
    data: data
  })
}

// 修改人事信息
export function updateRenshiINFO(data) {
  return request({
    url: '/system/renshiINFO',
    method: 'put',
    data: data
  })
}

// 删除人事信息
export function delRenshiINFO(staffid) {
  return request({
    url: '/system/renshiINFO/' + staffid,
    method: 'delete'
  })
}
