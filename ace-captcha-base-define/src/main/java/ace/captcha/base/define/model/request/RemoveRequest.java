package ace.captcha.base.define.model.request;

import ace.common.base.define.model.request.CommonAppRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 16:56
 * @description
 */
@Data
@Accessors(chain = true)
public class RemoveRequest extends CommonAppRequest {
}