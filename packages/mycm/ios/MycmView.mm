#ifdef RCT_NEW_ARCH_ENABLED
#import "MycmView.h"

#import <react/renderer/components/RNMycmViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNMycmViewSpec/EventEmitters.h>
#import <react/renderer/components/RNMycmViewSpec/Props.h>
#import <react/renderer/components/RNMycmViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import "Utils.h"

using namespace facebook::react;

@interface MycmView () <RCTMycmViewViewProtocol>

@end

@implementation MycmView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<MycmViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const MycmViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<MycmViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<MycmViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor: [Utils hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> MycmViewCls(void)
{
    return MycmView.class;
}

@end
#endif
