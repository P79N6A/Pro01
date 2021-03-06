import * as React from 'react';
import DropdownButton from './dropdown-button';
import { ConfigProviderProps } from '../config-provider';
export interface DropDownProps {
    trigger?: ('click' | 'hover' | 'contextMenu')[];
    overlay: React.ReactNode;
    onVisibleChange?: (visible?: boolean) => void;
    visible?: boolean;
    disabled?: boolean;
    align?: Object;
    getPopupContainer?: (triggerNode: Element) => HTMLElement;
    prefixCls?: string;
    className?: string;
    transitionName?: string;
    placement?: 'topLeft' | 'topCenter' | 'topRight' | 'bottomLeft' | 'bottomCenter' | 'bottomRight';
    overlayClassName?: string;
    overlayStyle?: React.CSSProperties;
    forceRender?: boolean;
    mouseEnterDelay?: number;
    mouseLeaveDelay?: number;
}
export default class Dropdown extends React.Component<DropDownProps, any> {
    static Button: typeof DropdownButton;
    static defaultProps: {
        prefixCls: string;
        mouseEnterDelay: number;
        mouseLeaveDelay: number;
        placement: string;
    };
    getTransitionName(): string;
    componentDidMount(): void;
    renderDropDown: ({ getPopupContainer: getContextPopupContainer }: ConfigProviderProps) => JSX.Element;
    render(): JSX.Element;
}
