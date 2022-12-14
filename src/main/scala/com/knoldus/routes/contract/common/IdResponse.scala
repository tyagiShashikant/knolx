package com.knoldus.routes.contract.common

import play.api.libs.json.{ Json, OWrites }

final case class IdResponse(id: String)

object IdResponse {
  implicit val IdResponseWrites: OWrites[IdResponse] = Json.writes[IdResponse]
}
