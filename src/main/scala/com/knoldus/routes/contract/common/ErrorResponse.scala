package com.knoldus.routes.contract.common

import play.api.libs.json.{ JsValue, Json, OWrites }

final case class ErrorResponse(
  code: Int,
  message: String,
  reason: Option[String] = None,
  errors: Seq[JsValue] = Seq.empty
)

object ErrorResponse {
  implicit val ErrorResponseWrites: OWrites[ErrorResponse] = Json.writes[ErrorResponse]
}
