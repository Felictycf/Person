import request from '@/utils/request'

// 查询职工培训列表
export function listZhigongpractice(query) {
  return request({
    url: '/system/zhigongpractice/list',
    method: 'get',
    params: query
  })
}

// 查询职工培训详细
export function getZhigongpractice(staffid) {
  return request({
    url: '/system/zhigongpractice/' + staffid,
    method: 'get'
  })
}

// 新增职工培训
export function addZhigongpractice(data) {
  return request({
    url: '/system/zhigongpractice',
    method: 'post',
    data: data
  })
}

// 修改职工培训
export function updateZhigongpractice(data) {
  return request({
    url: '/system/zhigongpractice',
    method: 'put',
    data: data
  })
}

// 删除职工培训
export function delZhigongpractice(staffid) {
  return request({
    url: '/system/zhigongpractice/' + staffid,
    method: 'delete'
  })
}
